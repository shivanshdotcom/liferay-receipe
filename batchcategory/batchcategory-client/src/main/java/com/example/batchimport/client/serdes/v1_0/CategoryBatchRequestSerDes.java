package com.example.batchimport.client.serdes.v1_0;

import com.example.batchimport.client.dto.v1_0.Category;
import com.example.batchimport.client.dto.v1_0.CategoryBatchRequest;
import com.example.batchimport.client.json.BaseJSONParser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Stream;

import javax.annotation.Generated;

/**
 * @author admin1
 * @generated
 */
@Generated("")
public class CategoryBatchRequestSerDes {

	public static CategoryBatchRequest toDTO(String json) {
		CategoryBatchRequestJSONParser categoryBatchRequestJSONParser =
			new CategoryBatchRequestJSONParser();

		return categoryBatchRequestJSONParser.parseToDTO(json);
	}

	public static CategoryBatchRequest[] toDTOs(String json) {
		CategoryBatchRequestJSONParser categoryBatchRequestJSONParser =
			new CategoryBatchRequestJSONParser();

		return categoryBatchRequestJSONParser.parseToDTOs(json);
	}

	public static String toJSON(CategoryBatchRequest categoryBatchRequest) {
		if (categoryBatchRequest == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (categoryBatchRequest.getBatchId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"batchId\": ");

			sb.append("\"");

			sb.append(_escape(categoryBatchRequest.getBatchId()));

			sb.append("\"");
		}

		if (categoryBatchRequest.getCategories() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"categories\": ");

			sb.append("[");

			for (int i = 0; i < categoryBatchRequest.getCategories().length;
				 i++) {

				sb.append(
					String.valueOf(categoryBatchRequest.getCategories()[i]));

				if ((i + 1) < categoryBatchRequest.getCategories().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (categoryBatchRequest.getTimestamp() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"timestamp\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(
					categoryBatchRequest.getTimestamp()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		CategoryBatchRequestJSONParser categoryBatchRequestJSONParser =
			new CategoryBatchRequestJSONParser();

		return categoryBatchRequestJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		CategoryBatchRequest categoryBatchRequest) {

		if (categoryBatchRequest == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (categoryBatchRequest.getBatchId() == null) {
			map.put("batchId", null);
		}
		else {
			map.put(
				"batchId", String.valueOf(categoryBatchRequest.getBatchId()));
		}

		if (categoryBatchRequest.getCategories() == null) {
			map.put("categories", null);
		}
		else {
			map.put(
				"categories",
				String.valueOf(categoryBatchRequest.getCategories()));
		}

		if (categoryBatchRequest.getTimestamp() == null) {
			map.put("timestamp", null);
		}
		else {
			map.put(
				"timestamp",
				liferayToJSONDateFormat.format(
					categoryBatchRequest.getTimestamp()));
		}

		return map;
	}

	public static class CategoryBatchRequestJSONParser
		extends BaseJSONParser<CategoryBatchRequest> {

		@Override
		protected CategoryBatchRequest createDTO() {
			return new CategoryBatchRequest();
		}

		@Override
		protected CategoryBatchRequest[] createDTOArray(int size) {
			return new CategoryBatchRequest[size];
		}

		@Override
		protected void setField(
			CategoryBatchRequest categoryBatchRequest,
			String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "batchId")) {
				if (jsonParserFieldValue != null) {
					categoryBatchRequest.setBatchId(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "categories")) {
				if (jsonParserFieldValue != null) {
					categoryBatchRequest.setCategories(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> CategorySerDes.toDTO((String)object)
						).toArray(
							size -> new Category[size]
						));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "timestamp")) {
				if (jsonParserFieldValue != null) {
					categoryBatchRequest.setTimestamp(
						toDate((String)jsonParserFieldValue));
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