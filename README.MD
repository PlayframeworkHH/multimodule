Example of a Play2 application that uses multiple projects
==========================================================

There is one main project and 4 subprojects:
- model (just a normal scala project without play)
- common (includes a BaseController that is used by the other subprojects)
- admin
- web

The project shows that with subprojects, really less files
are compiled when you change something (e.g. in routes or controllers)
than without subprojects.

When using "sbt run" in the main project, there is no real drawback of using subprojects.
All changes are picked up immediately, even changes in sub projects.

Things to be aware of:
- In a subproject that is not a Play project, you have to set the scala version
  explicitly in the Build file
- The variable name of the main project in the build file must be the first
  in the alphabet
- For FakeApplication to work in a subproject, you have to create an
  own application.conf for the subproject and give the FakeApplication the
  path to the subproject. See admin subproject.

Documentation about subprojects:
http://www.playframework.com/documentation/2.1.2/SBTSubProjects
