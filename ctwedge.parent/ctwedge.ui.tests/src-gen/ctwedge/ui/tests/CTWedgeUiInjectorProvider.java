/*
 * generated by Xtext 2.15.0
 */
package ctwedge.ui.tests;

import com.google.inject.Injector;
import ctwedge.ui.internal.CtwedgeActivator;
import org.eclipse.xtext.testing.IInjectorProvider;

public class CTWedgeUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return CtwedgeActivator.getInstance().getInjector("ctwedge.CTWedge");
	}

}
