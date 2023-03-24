/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2018, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.merative.acd.v1.common;

import java.util.List;
import org.junit.Assert;
import com.merative.acd.v1.model.SpellingCorrection;
import com.merative.acd.v1.model.Suggestion;

public class TestSpellCorrectionAnnotation {

	public static void testSpellCorrectionAnnotation(SpellingCorrection annotation) {
		Assert.assertTrue(annotation.getBegin() > -1);
		Assert.assertNotNull(annotation.getCoveredText());
		Assert.assertTrue(annotation.getEnd() > annotation.getBegin());
		List<Suggestion> suggestions = annotation.getSuggestions();
		if (suggestions != null && !suggestions.isEmpty()) {
			for (Suggestion suggestion : suggestions) {
				Assert.assertNotNull(suggestion.getApplied());
				Assert.assertTrue(suggestion.getConfidence() > 0);
				List<String> types = suggestion.getSemtypes();
				if (types != null && !types.isEmpty()) {
					Assert.assertTrue(types.size() > 0);
				}
				Assert.assertNotNull(suggestion.getText());
			}
		}
	}
}
