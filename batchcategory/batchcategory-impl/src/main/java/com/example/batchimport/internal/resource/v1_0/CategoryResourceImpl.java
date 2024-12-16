package com.example.batchimport.internal.resource.v1_0;

import com.example.batchimport.dto.v1_0.Category;
import com.example.batchimport.dto.v1_0.CategoryBatchRequest;
import com.example.batchimport.resource.v1_0.CategoryResource;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalService;
import com.liferay.asset.kernel.service.AssetVocabularyService;
import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portlet.asset.model.impl.AssetCategoryImpl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author admin1
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/category.properties",
	scope = ServiceScope.PROTOTYPE, service = CategoryResource.class
)
public class CategoryResourceImpl extends BaseCategoryResourceImpl {

	@Override
	public void setContextBatchUnsafeBiConsumer(
			UnsafeBiConsumer<Collection<Category>, UnsafeFunction<Category, Category, Exception>, Exception> contextBatchUnsafeBiConsumer) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public Response postBatchCategories(CategoryBatchRequest categoryBatchRequest) throws Exception {
		
		try {
			Category[] categories = categoryBatchRequest.getCategories();
			
			// Load existing categories for reference
			Map<String, Long> categoryMapping = loadExistingCategories();
			System.out.println("Existing categories: " + categoryMapping.size());
			
			for (Category category : categories) {
				ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

				// Resolve Vocabulary
				AssetVocabulary vocabulary = 
				    _assetVocabularyLocalService.getAssetVocabularyByExternalReferenceCode(
				        serviceContext.getScopeGroupId(), 
				        category.getVocabularyExternalReferenceCode()
				    );

				if (vocabulary == null) {
				    throw new IllegalArgumentException(
				        "Vocabulary not found: " + category.getVocabularyExternalReferenceCode());
				}
			    
				// Resolve Parent Category ID
				Long parentCategoryId = 0L; // Default to root category
				if (category.getParentExternalReferenceCode() != null) {
				    AssetCategory parentCategory = 
				        _assetCategoryLocalService.fetchAssetCategoryByExternalReferenceCode(category.getParentExternalReferenceCode(), serviceContext.getScopeGroupId());

				    if (parentCategory != null) {
				        parentCategoryId = parentCategory.getCategoryId();
				    } else {
				        throw new IllegalArgumentException(
				            "Parent category not found: " + category.getParentExternalReferenceCode());
				    }
				}
				
				// Prepare Title and Description Maps
				Map<Locale, String> titleMap = new HashMap<>();
				titleMap.put(Locale.getDefault(), category.getName());

				Map<Locale, String> descriptionMap = new HashMap<>();
				descriptionMap.put(Locale.getDefault(), category.getDescription());
				
				// Create the category with external reference code
				AssetCategory assetCategory = _assetCategoryLocalService.addCategory(
				    category.getExternalReferenceCode(), // External Reference Code
				    serviceContext.getUserId(),
				    serviceContext.getScopeGroupId(),
				    parentCategoryId,
				    titleMap,
				    descriptionMap,
				    vocabulary.getVocabularyId(),
				    null, // No additional category properties
				    serviceContext
				);
				
				// Log success
				System.out.println("Category created: " + category.getExternalReferenceCode());
			    
			}
			
			return Response.ok().build();
			
		} catch (PortalException e) {
			System.out.println("Error processing batch categories: "+ e);
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	
	}
	
	


	private Map<String, Long> loadExistingCategories() {
		Map<String, Long> categoryMapping = new HashMap<>();
        List<AssetCategory> existingCategories =
            _assetCategoryLocalService.getAssetCategories(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

        for (AssetCategory category : existingCategories) {
            categoryMapping.put(category.getExternalReferenceCode(), category.getCategoryId());
        }
        return categoryMapping;
		
	}
	
	 @Reference
	 private AssetCategoryLocalService _assetCategoryLocalService;
	 
	 @Reference
	 private AssetVocabularyService _assetVocabularyLocalService;
}