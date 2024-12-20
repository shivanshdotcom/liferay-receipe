package com.example.batchimport.client.serdes.v1_0;

import com.example.batchimport.client.dto.v1_0.Category;
import com.example.batchimport.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author admin1
 * @generated
 */
@Generated("")
public class CategorySerDes {

	public static Category toDTO(String json) {
		CategoryJSONParser categoryJSONParser = new CategoryJSONParser();

		return categoryJSONParser.parseToDTO(json);
	}

	public static Category[] toDTOs(String json) {
		CategoryJSONParser categoryJSONParser = new CategoryJSONParser();

		return categoryJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Category category) {
		if (category == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (category.getDescription() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(category.getDescription()));

			sb.append("\"");
		}

		if (category.getExternalReferenceCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"externalReferenceCode\": ");

			sb.append("\"");

			sb.append(_escape(category.getExternalReferenceCode()));

			sb.append("\"");
		}

		if (category.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(category.getName()));

			sb.append("\"");
		}

		if (category.getParentExternalReferenceCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"parentExternalReferenceCode\": ");

			sb.append("\"");

			sb.append(_escape(category.getParentExternalReferenceCode()));

			sb.append("\"");
		}

		if (category.getVocabularyExternalReferenceCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"vocabularyExternalReferenceCode\": ");

			sb.append("\"");

			sb.append(_escape(category.getVocabularyExternalReferenceCode()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		CategoryJSONParser categoryJSONParser = new CategoryJSONParser();

		return categoryJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Category category) {
		if (category == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (category.getDescription() == null) {
			map.put("description", null);
		}
		else {
			map.put("description", String.valueOf(category.getDescription()));
		}

		if (category.getExternalReferenceCode() == null) {
			map.put("externalReferenceCode", null);
		}
		else {
			map.put(
				"externalReferenceCode",
				String.valueOf(category.getExternalReferenceCode()));
		}

		if (category.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(category.getName()));
		}

		if (category.getParentExternalReferenceCode() == null) {
			map.put("parentExternalReferenceCode", null);
		}
		else {
			map.put(
				"parentExternalReferenceCode",
				String.valueOf(category.getParentExternalReferenceCode()));
		}

		if (category.getVocabularyExternalReferenceCode() == null) {
			map.put("vocabularyExternalReferenceCode", null);
		}
		else {
			map.put(
				"vocabularyExternalReferenceCode",
				String.valueOf(category.getVocabularyExternalReferenceCode()));
		}

		return map;
	}

	public static class CategoryJSONParser extends BaseJSONParser<Category> {

		@Override
		protected Category createDTO() {
			return new Category();
		}

		@Override
		protected Category[] createDTOArray(int size) {
			return new Category[size];
		}

		@Override
		protected void setField(
			Category category, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "description")) {
				if (jsonParserFieldValue != null) {
					category.setDescription((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "externalReferenceCode")) {

				if (jsonParserFieldValue != null) {
					category.setExternalReferenceCode(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					category.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "parentExternalReferenceCode")) {

				if (jsonParserFieldValue != null) {
					category.setParentExternalReferenceCode(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName,
						"vocabularyExternalReferenceCode")) {

				if (jsonParserFieldValue != null) {
					category.setVocabularyExternalReferenceCode(
						(String)jsonParserFieldValue);
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}