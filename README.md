# DNS_Servers
DNS Servers Implementation in Java
Lab 5 – Computer Networks
# Socket Programming
# Objectives
  To extend the knowledge of multithreaded communication Implementation of multi-tier multi-threaded servers in Java
# Background
  In many real life applications require an application to act as client and server simultaneously. For
example, an ATM machine acts as a client and connects to a server present in the nearest back branch.
However, this server does not have account information. To fulfill user requirements, this server needs
to act as client and connects to some other server which has account details. Such communication
systems can be termed multi-tier systems.

# Task
# Client
  A client connects to Main Server and requests any of the three services. The client provides all
necessary details and gets desired results.

# Main Server 
  This multi-threaded server has the information about where each service is implemented.
Whenever a client requests a service, the server creates a thread to serve the request. The request is
then served in collaboration with relevant Service Provider Server.
# Service Provider Servers 
  These servers actually implement a service. A total of 03 such servers are to
be implemented with following details:

I)   Server1 is an echo service i.e., returns the same string back as passed to it.

II)  Server2 is a palindrome service i.e., it return whether given string is palindrome or not.

III) Server3 simply returns length of a given string.

Best of Luck 
