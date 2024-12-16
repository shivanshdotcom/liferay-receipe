package com.example.batchimport.client.dto.v1_0;

import com.example.batchimport.client.function.UnsafeSupplier;
import com.example.batchimport.client.serdes.v1_0.CategoryBatchRequestSerDes;

import java.io.Serializable;

import java.util.Date;
import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author admin1
 * @generated
 */
@Generated("")
public class CategoryBatchRequest implements Cloneable, Serializable {

	public static CategoryBatchRequest toDTO(String json) {
		return CategoryBatchRequestSerDes.toDTO(json);
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public void setBatchId(
		UnsafeSupplier<String, Exception> batchIdUnsafeSupplier) {

		try {
			batchId = batchIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String batchId;

	public Category[] getCategories() {
		return categories;
	}

	public void setCategories(Category[] categories) {
		this.categories = categories;
	}

	public void setCategories(
		UnsafeSupplier<Category[], Exception> categoriesUnsafeSupplier) {

		try {
			categories = categoriesUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Category[] categories;

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public void setTimestamp(
		UnsafeSupplier<Date, Exception> timestampUnsafeSupplier) {

		try {
			timestamp = timestampUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date timestamp;

	@Override
	public CategoryBatchRequest clone() throws CloneNotSupportedException {
		return (CategoryBatchRequest)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CategoryBatchRequest)) {
			return false;
		}

		CategoryBatchRequest categoryBatchRequest =
			(CategoryBatchRequest)object;

		return Objects.equals(toString(), categoryBatchRequest.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return CategoryBatchRequestSerDes.toJSON(this);
	}

}