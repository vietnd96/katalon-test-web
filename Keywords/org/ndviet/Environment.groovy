package org.ndviet

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.configuration.RunConfiguration

import internal.GlobalVariable

public class Environment {
	@Keyword
	static def addGlobalVariable(String name, def value) {
		GroovyShell shell1 = new GroovyShell()
		MetaClass mc = shell1.evaluate("internal.GlobalVariable").metaClass
		String getterName = "get" + name.capitalize()
		mc.'static'."$getterName" = { -> return value }
		mc.'static'."$name" = value
	}

	@Keyword
	static def getDownloadsDirectory(def folder = 'output/Downloads') {
		def directory = RunConfiguration.getProjectDir() + File.separator + folder
		directory = new File(directory)
		if (!directory.exists()) {
			directory.mkdirs()
		}
		return directory.getAbsolutePath().toString()
	}

	@Keyword
	static def getDataFilesDirectory(def folder = 'Data Files') {
		def directory = RunConfiguration.getProjectDir() + File.separator + folder
		directory = new File(directory)
		if (!directory.exists()) {
			directory.mkdirs()
		}
		return directory.getAbsolutePath().toString()
	}
}
