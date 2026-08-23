/*
 * Copyright (C) 2024 The Libphonenumber Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.i18n.phonenumbers.geocoding;

import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import junit.framework.TestCase;

import java.util.Locale;

/**
 * Tests for Brazil geocoding that run against the real production dataset,
 * ensuring bug fixes to the core data (resources/geocoding/*) apply correctly.
 */
public class BrazilGeocodingTest extends TestCase {
  // Use getInstance() to load the actual production data rather than the test-only synthetic fixtures.
  private final PhoneNumberOfflineGeocoder geocoder = PhoneNumberOfflineGeocoder.getInstance();

  public void testItaquaquecetubaGeocoding() {
    // Number with the +55 11 4610-XXXX prefix
    PhoneNumber number = new PhoneNumber().setCountryCode(55).setNationalNumber(1146101234L);
    
    // Should map to "Itaquaquecetuba - SP" instead of "Cotia - SP" in both English and Portuguese
    assertEquals("Itaquaquecetuba - SP", geocoder.getDescriptionForNumber(number, Locale.ENGLISH));
    assertEquals("Itaquaquecetuba - SP", geocoder.getDescriptionForNumber(number, new Locale("pt", "BR")));
  }
}
