import re

prefixes = ['http://shanghai.anjuke.com', 'http://beijing.anjuke.com']

def readSrcFile():
    regList = []
    idfile = open("regSrc")
    lines = idfile.readlines()

    for line in lines:
        match = re.search('    ', line)
        if(match):
            regList.append(line.strip(' ,\'\n'))

    idfile.close()
    return regList

def parseReg(demo):
    result = demo
    result = result.replace('^', '')
    result = result.replace('$', '')
    result = result.replace('(.*)', 'testcase')
    result = result.replace('(.+)', 'testcase')
  # result = result.replace('([0-9]+)','1')
    # result = result.replace('([a-z]*)','a')

    searchResult = re.search('\[(.*)\][\+\*] ', result)
    if(searchResult):
        result = result.replace(searchResult.group(), re.match('\[(.*)\-', searchResult.group()).group(1))
    return result
regList = readSrcFile()

for demo in regList:
    for prefix in prefixes:
        print(parseReg(demo))
        print(prefix + parseReg(demo))
