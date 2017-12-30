/**
 * Add the XmlJavaTypeAdapter to all classes within the package
 * 
 * @author frank
 *
 */
@XmlJavaTypeAdapters({
		@XmlJavaTypeAdapter(type = LocalDate.class,
				value = LocalDateAdapter.class)
})
package com.avoodoo.example.service.soap.model.employee;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;

import com.avoodoo.example.service.util.LocalDateAdapter;

