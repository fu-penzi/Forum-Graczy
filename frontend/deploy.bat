rm -rf deploy/static
xcopy build deploy /s /e /y
cd deploy
git add .
git status
pause
git commit -m "Automatic commit"
git push -u origin master
pause