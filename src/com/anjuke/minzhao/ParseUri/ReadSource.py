import re

regList1 = []
try:
    data = open('regSrc')
    for each_line in data:
        match = re.search('    ',data)
        if match:
            regList1.append(each_line.strip(' ,\'\n'))
    data.close()
except IOError:
    print('the datafile is missing!')
