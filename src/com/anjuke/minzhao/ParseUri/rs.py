import urllib2, urllib, csv

class RedirectHandler(urllib2.HTTPRedirectHandler):
    def http_error_301(self, req, fp, code, msg, headers):
        result = urllib2.HTTPRedirectHandler.http_error_301(self, req, fp, code, msg, headers)
        result.status = code
        return result

    def http_error_302(self, req, fp, code, msg, headers):
        result = urllib2.HTTPRedirectHandler.http_error_302(self, req, fp, code, msg, headers)
        result.status = code
        return result


def parseResponse(input_url):
    try:
        data = {"name": "hank", "passwd": "hjz"}
        headers = {"User-Agent": "JUC (Linux; U; 4.0.3; zh-cn; U18GT; 480*764) UCWEB1.0.1.113/147/800"}
        opener = urllib2.build_opener(RedirectHandler)
        urllib2.install_opener(opener)
        request = urllib2.Request(input_url, urllib.urlencode(data), headers)
        response = urllib2.urlopen(request)
        #print response.status

        print response.geturl()
        if 'touchweb' in response.read():
            return 'touchweb'
        else:
            return 'pc'
    except:
        return 'error'

# This is a demo
print parseResponse("http://shanghai.anjuke.com/")

# read and parse file
reader = csv.reader(file('Match_Regex_Demo_url.csv', 'rb'))
writer = csv.writer(file('Match_Regex_Demo_Url_Result.csv', 'wb'))
for line in reader:
    if line[1].startswith('http'):
        writer.writerow([line[0], line[1], line[2], parseResponse(line[1])])