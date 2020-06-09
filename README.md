# basic_auth
RESTful Basic Authentication and Authorization Tutorial.

Using Jersey framework for REST API implementation

# Basic Authentication
You can pass your credentials(format - uasername:password) as a Base64-encoded header or as parameters in an HTTP client.

When you pass your credentials in the header, you must Base64-encode them. The following is an example of an encoded HTTP Basic Authentication header:

Authorization: Basic YWhhbWlsdG9uQGFwaWdlZS5jb206bXlwYXNzdzByZAo
