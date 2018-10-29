/**
 * generated by Xtext 2.12.0
 */
package ctwedge.ui.wizard;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.resource.FileExtensionProvider;

@SuppressWarnings("all")
public class CTWedgeNewProjectWizardInitialContents {
  @Inject
  private FileExtensionProvider fileExtensionProvider;
  
  public void generateInitialContents(final IFileSystemAccess2 fsa) {
    String _primaryFileExtension = this.fileExtensionProvider.getPrimaryFileExtension();
    String _plus = ("src/model/Model." + _primaryFileExtension);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* This is an example model");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("Model Phone");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("Parameters:");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("emailViewer : Boolean");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("textLines:  [ 25 .. 30 ]");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("display : {16MC, 8MC, BW}");
    _builder.newLine();
    _builder.newLine();
    _builder.append(" ");
    _builder.append("Constraints:");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("# emailViewer => textLines > 28 #");
    _builder.newLine();
    fsa.generateFile(_plus, _builder);
  }
}
