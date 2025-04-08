@echo off
setlocal

:: Set Java executable path
set JAVA_EXEC=java

:: Set the correct JAR file name (update if needed)
set JAR_NAME=player-communication-1.0-SNAPSHOT.jar

:: Set the full path to the JAR in the target folder
set JAR_PATH=target\%JAR_NAME%

echo ====================================================
echo  Player Communication - Java Application
echo ====================================================
echo Choose an execution mode:
echo [1] Single Process Mode (Threads)
echo [2] Multi Process Mode (Separate Java Processes)
echo [3] Exit
set /p choice="Enter your choice (1/2/3): "

if "%choice%"=="1" (
    echo Running Single Process Mode...
    %JAVA_EXEC% -jar %JAR_PATH%
    goto end
)

if "%choice%"=="2" (
    echo Starting Server...
    start cmd /k %JAVA_EXEC% -cp %JAR_PATH% com.example.Server

    timeout /t 2 >nul

    echo Starting Client...
    start cmd /k %JAVA_EXEC% -cp %JAR_PATH% com.example.Client
    goto end
)

if "%choice%"=="3" (
    echo Exiting...
    exit /b
)

echo Invalid choice! Please restart the script and select 1, 2, or 3.

:end
endlocal
