SET ROOT_WORK_JSP=C:\dev\bundles\liferay-dxp-7-ga1\work\dxp-book-rest-client-1.0.0\org
SET ROOT_DEPLOY=C:\dev\bundles\liferay-dxp-7-ga1\deploy
SET ROOT_DEPLOY_FILE=C:\dev\ws\liferay-ws\modules\dxp-book-rest-client\build\libs
SET ROOT_BUILD=C:\dev\ws\liferay-ws\modules\dxp-book-rest-client\build\resources\main\META-INF

: clean resource files
RD /S /Q %ROOT_BUILD%

: clean cached jsp on liferay server
RD /S /Q %ROOT_WORK_JSP%

CALL blade gw build

CALL blade deploy

:COPY "%ROOT_DEPLOY_FILE%\*.jar" "%ROOT_DEPLOY%"
