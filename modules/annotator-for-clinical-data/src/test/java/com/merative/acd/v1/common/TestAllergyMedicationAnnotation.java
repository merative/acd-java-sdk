/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2022, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.merative.acd.v1.common;

import java.util.List;
import org.junit.Assert;
import com.merative.acd.v1.model.AllergyMedicationInd;
import com.merative.acd.v1.model.MedicationAnnotation;

public class TestAllergyMedicationAnnotation {

	public static void testAllergyMedicationAnnotation(AllergyMedicationInd annotation) {
		Assert.assertTrue(annotation.getBegin() > -1);
		if (annotation.getCoveredText() != null && !annotation.getCoveredText().isEmpty()) {
			Assert.assertTrue(annotation.getCoveredText().length() > 0);
		}
		Assert.assertTrue(annotation.getEnd() > annotation.getBegin());
		if (annotation.getId() != null){
			Assert.assertTrue(annotation.getId().length() > 0);
		}
		if (annotation.getType() != null && !annotation.getType().isEmpty()) {
			Assert.assertTrue(annotation.getType().length() > 0);
		}
		if (annotation.getUid() != null){
			Assert.assertTrue(annotation.getUid() > 0);
		}
		Assert.assertNotNull(annotation.isHypothetical());
		Assert.assertNotNull(annotation.isNegated());
		List<MedicationAnnotation> medications = annotation.getMedication();
		if (medications != null) {
			Assert.assertTrue(medications.size() > 0);
			for (MedicationAnnotation medication : medications) {
				Assert.assertTrue(medication.getBegin() > -1);
				Assert.assertTrue(medication.getEnd() > medication.getBegin());
				Assert.assertNotNull(medication.getCoveredText());
			}
		}
	}
}
