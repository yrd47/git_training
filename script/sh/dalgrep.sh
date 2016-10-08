#!/usr/bin/env sh

#获取当前目录
curr_dir=`pwd`
cd "$curr_dir"
readonly curr_dir=`pwd`

pattern_map_file=${curr_dir}/athena_pattern_map.log

#用于快速失败的自杀函数
function die()
{
        echo "$*"
        exit 1
}

function usage()
{
    echo "Usage: "
    echo "\tdalgrep <sql pattern> [egrep parameters] [FILE]"
}

function filter_hash_by_sql()
{
    hashs=`fgrep "$1" ${pattern_map_file} | awk -F'#' '{print $1}' | tr '\n' '|'`
    hashs=${hashs%|}
    if [ ${#hashs} -eq 0 ]; then
        echo "00000000000000000000000000000000"
    else
        echo ${hashs}
    fi
}

#检查当前脚本执行路径下是否存在sql pattern映射文件: athena_pattern_map.log
function env_check()
{
    [ -f ${pattern_map_file} ] || die "Please check if " ${pattern_map_file} "exist!"
}

env_check
[ $# -eq 0 ] && usage && die "Please input sql pattern"

pattern="$1"
#左移参数，剔除已经获得的pattern 值
shift 1
egrep $(filter_hash_by_sql "$pattern") "$@"