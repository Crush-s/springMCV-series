#!/bin/sh

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

# 调用函数，传入顶级目录为/root
readDir /home/shellGITHUB/waitForfile


msg=$(date "+%Y.%m.%d")
   git add -A
   git commit -m"${msg}"
   git pull
   git status
   git push origin master 


