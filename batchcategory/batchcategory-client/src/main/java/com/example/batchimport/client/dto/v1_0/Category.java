package com.example.batchimport.client.dto.v1_0;

import com.example.batchimport.client.function.UnsafeSupplier;
import com.example.batchimport.client.serdes.v1_0.CategorySerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author admin1
 * @generated
 */
@Generated("")
public class Category implements Cloneable, Serializable {

	public static Category toDTO(String json) {
		return CategorySerDes.toDTO(json);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDescription(
		UnsafeSupplier<String, Exception> descriptionUnsafeSupplier) {

		try {
			description = descriptionUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String description;

	public String getExternalReferenceCode() {
		return externalReferenceCode;
	}

	public void setExternalReferenceCode(String externalReferenceCode) {
		this.externalReferenceCode = externalReferenceCode;
	}

	public void setExternalReferenceCode(
		UnsafeSupplier<String, Exception> externalReferenceCodeUnsafeSupplier) {

		try {
			externalReferenceCode = externalReferenceCodeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String externalReferenceCode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setName(UnsafeSupplier<String, Exception> nameUnsafeSupplier) {
		try {
			name = nameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String name;

	public String getParentExternalReferenceCode() {
		return parentExternalReferenceCode;
	}

	public void setParentExternalReferenceCode(
		String parentExternalReferenceCode) {

		this.parentExternalReferenceCode = parentExternalReferenceCode;
	}

	public void setParentExternalReferenceCode(
		UnsafeSupplier<String, Exception>
			parentExternalReferenceCodeUnsafeSupplier) {

		try {
			parentExternalReferenceCode =
				parentExternalReferenceCodeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String parentExternalReferenceCode;

	public String getVocabularyExternalReferenceCode() {
		return vocabularyExternalReferenceCode;
	}

	public void setVocabularyExternalReferenceCode(
		String vocabularyExternalReferenceCode) {

		this.vocabularyExternalReferenceCode = vocabularyExternalReferenceCode;
	}

	public void setVocabularyExternalReferenceCode(
		UnsafeSupplier<String, Exception>
			vocabularyExternalReferenceCodeUnsafeSupplier) {

		try {
			vocabularyExternalReferenceCode =
				vocabularyExternalReferenceCodeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String vocabularyExternalReferenceCode;

	@Override
	public Category clone() throws CloneNotSupportedException {
		return (Category)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Category)) {
			return false;
		}

		Category category = (Category)object;

		return Objects.equals(toString(), category.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return CategorySerDes.toJSON(this);
	}

}