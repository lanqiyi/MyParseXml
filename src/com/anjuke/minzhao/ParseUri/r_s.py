# -*- coding: utf-8 -*-
import urllib2,urllib
# 创建新的类，获取301，302状态
class RedirectHandler(urllib2.HTTPRedirectHandler):
    def http_error_301(self, req, fp, code, msg, headers):
        result = urllib2.HTTPRedirectHandler.http_error_301(self, req, fp, code, msg, headers)
        result.status = code
        return result
    def http_error_302(self, req, fp, code, msg, headers):
        result = urllib2.HTTPRedirectHandler.http_error_302(self, req, fp, code, msg, headers) 
	result.status = code
	return result 

# 可以把input_url  和 headers 进行参数化 批量处理
input_url = "http://shanghai.anjuke.com/community/props/sale/3536" 
data={"name":"hank", "passwd":"hjz"}
headers={"User-Agent": "JUC (Linux; U; 4.0.3; zh-cn; U18GT; 480*764) UCWEB1.0.1.113/147/800"}
opener = urllib2.build_opener(RedirectHandler)
urllib2.install_opener(opener)
request = urllib2.Request(input_url,urllib.urlencode(data),headers)
response = urllib2.urlopen(request)
print response.status
print response.geturl()
if 'touchweb' in response.read():
    print 'touchweb'
else:
    print 'pc'


