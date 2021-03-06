package ctwedge.generator.acts;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;

import ctwedge.ctWedge.CitModel;
import ctwedge.ctWedge.Constraint;
import ctwedge.ctWedge.Parameter;
import ctwedge.ctWedge.util.CtWedgeSwitch;
import ctwedge.util.TestSuite;
import ctwedge.util.ext.ICTWedgeTestGenerator;
import ctwedge.util.ext.NotConvertableModel;
//import edu.uta.cse.fireeye.common.Constraint;
//import edu.uta.cse.fireeye.common.Parameter;
import edu.uta.cse.fireeye.common.Relation;
import edu.uta.cse.fireeye.common.SUT;
import edu.uta.cse.fireeye.common.TestGenProfile.Algorithm;
import edu.uta.cse.fireeye.common.TestSet;
import edu.uta.cse.fireeye.service.engine.IpoEngine;

/** Exports to ACTS a citlab model, has a method to call ACTS, and returns its output into String **/
public class ACTSTranslator extends ICTWedgeTestGenerator {

	public static boolean PRINT=false;
	
	public ACTSTranslator() {
		super("ACTS");
	}

	public void convertModel(CitModel citModel, Boolean constraintUse, int nWise, String path) {

		try {
			saveActsTXTonlyModel(citModel, path);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// accept only paramters with ascii names
	static CharsetEncoder asciiEncoder = Charset.forName("US-ASCII")
			.newEncoder(); // or "ISO-8859-1" for ISO Latin 1

	public static boolean isPureAscii(String v) {
		return asciiEncoder.canEncode(v);
	}

	/**
	 * translate a citModel from citlab to ACTS SUT
	 * 
	 * @param ignoreConstraints
	 * @throws NotConvertableModel
	 * 
	 */
	public SUT buildSUT(CitModel citModel, boolean ignoreConstraints, int nWise) {
		SUT sut = new SUT(citModel.getName());
		try {
			if (PRINT) System.out.println("Building SUT...");
			// build a system configuration
			if (PRINT) System.out.println("Building SUT...");
			// it is recommended to create a new parameter from the SUT object
			// doing so will assign the parameter with an ID automatically
			ACTSParameterAdder paramBuilder = new ACTSParameterAdder(sut);
			tanslateParameter(citModel, paramBuilder);
	
			if (PRINT) System.out.println("Building SUT...");
			//
			// create relation
			Relation r = new Relation(nWise);
			for (edu.uta.cse.fireeye.common.Parameter p : sut.getParameters()) {
				r.addParam(p);
			}
			// add this relation into the sut
			sut.addRelation(r);
	
			// add the default relation
			// sut.addDefaultRelation(nWise);
	
			if (PRINT) System.out.println("Building SUT...");
			// create constraints
			if (!ignoreConstraints) {
				translateConstraints(citModel, sut);
			}
			//ConstraintManager  cm = new ConstraintManager(sut); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sut;
	}

	private void translateConstraints(CitModel citModel, SUT sut) {
		ACTSConstraintTranslator trans = new ACTSConstraintTranslator(citModel);
		CtWedgeSwitch<ArrayList<edu.uta.cse.fireeye.common.Parameter>> parameterFinder = new CtWedgeSwitch<>();
		
		if (PRINT) System.out.println(ACTSConstraintTranslator.dump(citModel, ""));
		for (Constraint c : citModel.getConstraints()) {
			// to String
			String casString = trans.doSwitch(c);
			if (PRINT) System.out.println("casString: "+casString);
			assert casString != null;
			// to list of parameters
			ArrayList<edu.uta.cse.fireeye.common.Parameter> pInC = parameterFinder.doSwitch(c);
			if (PRINT) System.out.println(pInC);
			// TODO for now, it is null and it works the same

			edu.uta.cse.fireeye.common.Constraint constraint = new edu.uta.cse.fireeye.common.Constraint(casString, pInC);
			assert constraint!=null : "Constraint null";
			sut.addConstraint(constraint);

		}
	}

	private void tanslateParameter(CitModel citModel, ACTSParameterAdder paramBuilder) {
		for (ctwedge.ctWedge.Parameter p : citModel.getParameters()) {
			String name = p.getName();
			if (!isPureAscii(name)){
				// "parameter " + name + " is not US-ASCII . choco has problems");				
			}
			// "adding parameter " + name);
			paramBuilder.doSwitch(p);
		}
	}
	
	// IMPORTER METHODS
	
	public TestSuite getTestSuite(CitModel model, int strength, boolean ignoreConstraints) {
		String res = "";
		if (PRINT) System.out.println("ACTS sto chiamando ACTS... on "+model.getName()+" "+strength+" "+ignoreConstraints);
		try {
			SUT sut = buildSUT(model, ignoreConstraints, strength);
			if (PRINT) System.out.println("1. ACTS sto chiamando ACTS...");
			// Create an IPO engine object
			IpoEngine engine = new IpoEngine(sut);
			if (PRINT) System.out.println("2. ACTS sto chiamando ACTS...");
			// build a test set
			
			if (PRINT) System.out.println("3. ACTS sto chiamando ACTS...");
			//System.setOut(new PrintStream(new ByteArrayOutputStream()));
			if (PRINT) System.out.println("4. ACTS sto chiamando ACTS...");
			engine.buildOnlyPT(Algorithm.ipog);
			if (PRINT) System.out.println("5. ACTS sto chiamando ACTS...");
			//engine.buildSupportedNT(getAlgorithm());
			
			// get the resulting test set
			if (PRINT) System.out.println("6. ACTS sto chiamando ACTS...");
			TestSet ts = engine.getTestSet();
			if (PRINT) System.out.println("7. ACTS sto chiamando ACTS...");
			res = serializeTestSet(model, ts);
		} catch (Exception e) {
			if (PRINT) System.out.println("Error: "+e.getMessage());
			e.printStackTrace();
		}
		
		if (PRINT) System.out.println("Obtained res: "+res);
		
		/*
		CitModel m = ModelsFromStringsTester.loadModel(model);
		try {
			TestPolicy tp = IgnoringConstraints.getInstance();
			ICitLabTestGenerator gen = new RandomGenerator();
			if (generator!=null) switch (generator) {
			case "random": break;
			case "acts": gen = new BaseChoiceGenerator(); break;
			case "ipof": gen = new IpoFGenerator(); break;
			case "ipogd": gen = new IpoGDGenerator(); break;
			case "ipog": gen = new IpoGGenerator(); break;
			case "casa": gen = new TSGeneratorByCasa(); break;
			case "medici": gen = new TSGeneratorByMedici(); break;
			case "smt": gen = new GeneratorBySMT(); break;
			case "ipo": gen = new IPOgenerator(); break;
			default: gen = new RandomGenerator(); break;
			}
			TestSuite ts = tp.produceTestSuite(m, gen, 2);
			res = new TestSuiteWriter().caseTestSuite(ts).toString();
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			res = sw.toString(); // stack trace as a string
		}
		*/
		return new TestSuite(res, model);
	}

	/** returns the test set as a CSV string, with heading */
	public static String serializeTestSet(CitModel model, TestSet ts) {
		StringBuilder sb = new StringBuilder();
		assert ts!=null : "TestSet null";
		String[][] matrix = getTestSuiteMatrix(model, ts);
		for (int i=0; i<matrix.length; i++) {
			sb.append(matrix[i][0]);
			for (int j=1; j<matrix[i].length; j++) sb.append(";"+matrix[i][j]);
			sb.append("\n");
		}
		return sb.toString();
	}
	
	/** get actual values of parameters in the test set (not only 0 1 2...) */
	public static String[][] getTestSuiteMatrix(CitModel model, TestSet ts) {
		assert ts!=null : "TestSet null";
		//sb.append(ts+"\n ");
		ArrayList<int[]> matrix = ts.getMatrix();
		String[][] m = new String[matrix.size()+1][model.getParameters().size()];
		
		for (int i=0; i<model.getParameters().size(); i++) {
			Parameter p = model.getParameters().get(i);
			m[0][i] = p.getName();
			int j=0; while (j<model.getParameters().size() && !ts.getParam(j).getName().equals(p.getName())) j++;
			for (int r=0; r<matrix.size(); r++) m[r+1][i]=""+ts.getParam(j).getValue(matrix.get(r)[j]);
		}
		return m;
	}
	
	

	public static TestSuite getTestSuite(CitModel model, TestSet ts) {
		return new TestSuite(serializeTestSet(model,ts), model);
	}
	
	/** Added to create the actual test suite */
//	public static TestSuite getTestSuite(String serializedTestSuite) {
//		TestSuite ts = new TestSuite(serializedTestSuite);
//		
//		return ts;
//	}
//	
	// OTHER UTILS
	public File saveActsTXTonlyModel(CitModel citModel, String dirPath) throws IOException{
		SUT sut = new SUT(citModel.getName());
		// it is recommended to create a new parameter from the SUT object
		// doing so will assign the parameter with an ID automatically
		ACTSParameterAdder paramBuilder = new ACTSParameterAdder(sut);
		tanslateParameter(citModel, paramBuilder);
		
		if (citModel.getConstraints().size()>0) {
			translateConstraints(citModel, sut);
		}
		String pathToFile = citModel.getName()+".txt";
		File txtFile = new File(dirPath+File.separator+pathToFile);

		try {
			
			PrintWriter p = new PrintWriter(txtFile);

			p.println("[System]");
			p.println("-- specify system name");
			p.println("Name: " + sut.getName());
			p.println();

			p.println("[Parameter]");
			p.println("-- general syntax is parameter_name : value1, value2, ...");
			int ptype;
			String origStr;
			for (edu.uta.cse.fireeye.common.Parameter parameter : sut.getParams()) {
				ptype = parameter.getParamType();
				String ptypeStr = "";
				switch (ptype) {
				case 2:
					ptypeStr = "boolean";
					break;
				case 1:
					ptypeStr = "enum";
					break;
				case 0:
					ptypeStr = "int";
					break;
				case -1:
					ptypeStr = "invalid";
				}

				String basechoiceValuePrefix = "[";
				String basechoiceValueSuffix = "]";
				ArrayList<String> validValues = new ArrayList<String>();
				for (int i = 0; i < parameter.getValues().size(); i++) {
					if (parameter.isBaseChoice(i)) {
						validValues.add(basechoiceValuePrefix + parameter.getValue(i) + basechoiceValueSuffix);
					} else
						validValues.add(parameter.getValue(i));
				}
				origStr = validValues.toString();
				String valueStr = origStr.substring(1, origStr.length() - 1);

				if (!parameter.getInvalidValues().isEmpty()) {
					String invalidValuesMarker = " ; ";
					ArrayList<String> invalidValues = new ArrayList<String>();

					for (String value : parameter.getInvalidValues()) {
						invalidValues.add(value);
					}
					origStr = invalidValues.toString();
					valueStr = valueStr + invalidValuesMarker + origStr.substring(1, origStr.length() - 1);
				}

				p.println(parameter.getName() + " (" + ptypeStr + ") : " + valueStr);
			}
			p.println();

			p.println("[Relation]");
			p.println("-- this section is optional");
			p.println("-- general format Rx : (p1, p2, ..., pk, Strength)");
			int x = 0;
			for (Relation relation : sut.getRelations()) {
				x++;
				p.println("R" + x + " : (" + relation.getParamNames() + ", " + relation.getStrength() + ")");
			}
			p.println();

			if (sut.getConstraintManager().getConstraints().size() > 0) {
				p.println("[Constraint]");
				p.println("-- this section is also optional");
				for (edu.uta.cse.fireeye.common.Constraint constraint : sut.getConstraintManager().getConstraints()) {
					p.println(constraint.getText());
				}
			}
			p.println();
			if (PRINT) System.out.println("IGNORING TSs");
			
			p.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return txtFile;
	}

	@Override
	public TestSuite call() throws Exception {
		if (PRINT) System.out.println("ACTS chiamato");
		if (PRINT) System.out.println("citModel: "+citModel+"  nWise: "+nWise+"  ignoreConstraints: "+ignoreConstraints);
		TestSuite ts = getTestSuite(citModel, nWise, ignoreConstraints);
		if (PRINT) System.out.println("ACTS test suite: "+ts);
		return ts;
	}
	

}
