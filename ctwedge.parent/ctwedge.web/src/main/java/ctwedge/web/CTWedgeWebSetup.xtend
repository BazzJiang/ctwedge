/*
 * generated by Xtext 2.12.0
 */
package ctwedge.web

import com.google.inject.Guice
import com.google.inject.Injector
import ctwedge.CTWedgeRuntimeModule
import ctwedge.CTWedgeStandaloneSetup
import ctwedge.ide.CTWedgeIdeModule
import org.eclipse.xtext.util.Modules2

/**
 * Initialization support for running Xtext languages in web applications.
 */
class CTWedgeWebSetup extends CTWedgeStandaloneSetup {
	
	override Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new CTWedgeRuntimeModule, new CTWedgeIdeModule, new CTWedgeWebModule))
	}
	
}
