# ctwedge
 Combinatorial Testing Web Editor and GEnerator

 
ctwedge.benchmarks   => benchmarks
					-d-> ctwedge & generator (why ?)

ctwedge.eclipse  => eclipse plugins
	ctwedge.eclipse  => extension points and abstract classes (generator)
					-d-> ctwedge
	ctwedge.eclipse.feature => feature for update site
	ctwedge.eclipse.ui => UI extensions for buttons and so on, view, tables ....

ctwedge.generator => the generators (ACTS, CASA ...) 
				-d-> ctwedge, ctwedge.eclipse 
ctwedge.generator.test 
ctwedge.generator.webapp => servlets for generation
						-d-> ctwedge.generator
ctwedge.generator.webapp.test

ctwedge.parent  => language definitions
	ctwedge
	ctwedge.ide
	ctwedge.web  => web editor
	gradle
