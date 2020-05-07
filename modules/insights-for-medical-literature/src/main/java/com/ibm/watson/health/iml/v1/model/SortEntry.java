/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.watson.health.iml.v1.model;

/**
 * Sort Entry.
 *
 */
public class SortEntry {

	private String field;
	private Order sortOrder;

	/**
	 * Sort Order.
	 * ASC = ascending
	 * DESC = descending
	 */
    public enum Order {
        ASC("asc"),
        DESC("desc");

        private String order;

        /**
         * Returns sort order.
         * @return order
         */
        public String getOrder() {
            return this.order;
        }

        // enum constructor - cannot be public or protected
        Order(String order) {
            this.order = order;
        }
    }

    /**
     * Constructor.
     */
    public SortEntry() {

    }

    /**
     * Returns field being sorted.
     * @return field name
     */
	public String getField() {
		return field;
	}

	/**
	 * Sets field name to sort.
	 * @param fieldName field to sort on
	 */
	public void setField(String fieldName) {
		field = fieldName;
	}

	/**
	 * Returns sort order (Ascending or Descending).
	 * @return order
	 */
	public Order getFOrder() {
		return sortOrder;
	}

	/**
	 * Sets sort order for field.
	 * @param order sort order
	 */
	public void setOrder(Order order) {
		sortOrder = order;
	}
}
