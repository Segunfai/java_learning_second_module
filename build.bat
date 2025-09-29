@echo off
chcp 65001 > nul
echo Компиляция DungeonMini...

cd /d "C:\Users\Segunfai\IdeaProjects\java_learning_second_module"

mkdir build\classes 2>nul

echo Компилируем core классы...
javac -d build\classes -encoding UTF-8 src\attestation02_dungeon\core\*.java

echo Компилируем model классы...
javac -d build\classes -encoding UTF-8 src\attestation02_dungeon\model\*.java

if %errorlevel% equ 0 (
    echo ✅ Компиляция успешна!
    echo Проверяем созданные классы...
    dir build\classes\attestation02_dungeon\ /s
) else (
    echo ❌ Ошибка компиляции!
    pause
    exit /b 1
)