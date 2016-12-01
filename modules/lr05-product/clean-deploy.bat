SET ROOT_WORK_JSP=C:\dev\bundles\liferay-dxp-7-ga1\work\lr05.product-1.0.0\org
SET ROOT_DEPLOY=C:\dev\bundles\liferay-dxp-7-ga1\deploy
:SET ROOT_WAR_FILE=C:\dev\ws\maven-portlet\target
RD /S /Q %ROOT_WORK_JSP%
:mvn clean package liferay:deploy
:CALL MVN clean package
:COPY "%ROOT_WAR_FILE%\*.war" "%ROOT_DEPLOY%"
