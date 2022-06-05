#/bin/bash

true
echo $?
 
false
echo $?
 
test 'abc' == 'abc'
echo $?
 
test 'abc' == 'acb'
echo $?
 
name = 'Tom'
test -n $name
echo $?
 
test -d /usr/bin
echo $?
 
 
if [ $? -eq 0 ]; then
    echo "success"
else
    echo "failed"
fi

echo 1234567

git pull 
if [ $? -eq 0 ]; then
    echo "git pull 执行成功"
else
    echo "git pull 执行失败"
fi
source /usr/local/sendEmail/shellList/test.sh
successPull
echo 9999
