/**
 * generated by Xtext 2.13.0
 */
package ctwedge.web;

import com.google.inject.Guice;
import com.google.inject.Injector;
import ctwedge.CTWedgeRuntimeModule;
import ctwedge.CTWedgeStandaloneSetup;
import ctwedge.ide.CTWedgeIdeModule;
import ctwedge.web.CTWedgeWebModule;
import org.eclipse.xtext.util.Modules2;

/**
 * Initialization support for running Xtext languages in web applications.
 */
@SuppressWarnings("all")
public class CTWedgeWebSetup extends CTWedgeStandaloneSetup {
  @Override
  public Injector createInjector() {
    CTWedgeRuntimeModule _cTWedgeRuntimeModule = new CTWedgeRuntimeModule();
    CTWedgeIdeModule _cTWedgeIdeModule = new CTWedgeIdeModule();
    CTWedgeWebModule _cTWedgeWebModule = new CTWedgeWebModule();
    return Guice.createInjector(Modules2.mixin(_cTWedgeRuntimeModule, _cTWedgeIdeModule, _cTWedgeWebModule));
  }
}