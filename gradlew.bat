@echo off
setlocal

set "APP_HOME=%~dp0"

if defined JAVA_HOME (
    set "JAVA_COMMAND=%JAVA_HOME%\bin\java.exe"
) else (
    set "JAVA_COMMAND=java.exe"
)

"%JAVA_COMMAND%" -classpath "%APP_HOME%gradle\wrapper\gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain %*
exit /b %ERRORLEVEL%
