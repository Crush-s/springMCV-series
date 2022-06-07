#!/bin/bash
source /etc/profile
source ~/.bash_profile
# 引入发送电子邮件脚本
source /home/shellGITHUB/shellAll/shellEmail.sh

# 存放文件的路径
# 采集一个函数
readDir() {
  # 获取传入的目录路径
  local dir=$1
  # 循环指定目录下的所有文件
  local files
  files=$(ls "$dir")
  for file in $files; do
    local path="$dir/$file" #指的是当前遍历文件的完整路径
    # 判断是否是目录，如果是目录则递归遍历，如果是文件则打印该文件的完整路径
    if [ -d "$path" ]; then
      readDir "$path"
    else
      echo "$path"
      cp $path /home/shellGITHUB/project/springMCV-series/chat01-helloword/src/main/java/com/javacode2018/springmvcseries/chat01
      rm $path
      break
    fi
  done
}

# git相关操作
gitOperation() {
	# 定义commit信息
	msg=$(date "+%Y.%m.%d")
	git add -A
	git commit -m"${msg}"
	echo "git commit 执行成功" >> /home/shellGITHUB/shellAll/log.txt
	git pull
	echo "git pull 执行成功" >> /home/shellGITHUB/shellAll/log.txt
	git status
	echo "git status 执行成功" >> /home/shellGITHUB/shellAll/log.txt
	git push origin master
	echo "git push 执行成功" >> /home/shellGITHUB/shellAll/log.txt
}

echo $(date "+%Y.%m.%d")开始 >> /home/shellGITHUB/shellAll/log.txt
# 调用函数，传入顶级目录为/root
readDir /home/shellGITHUB/waitForfile
echo "复制文件结束！"  >> /home/shellGITHUB/shellAll/log.txt
# 调用git相关函数
gitOperation
