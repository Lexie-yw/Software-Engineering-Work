**Evaluation**

A Mock test is a test in which some complex object (such as a ResultSet object in JDBC) is not easy to construct (such as HttpServletRequest must be constructed in a Servlet container) or is not easy to obtain. A Mock object is used to create test methods that can be tested.

Mocks are designed to solve problems that are difficult to develop and test due to coupling between different units. Therefore, mocks can be used in unit tests as well as during integration tests and system tests. The most important thing about mocks is that they help you decouple unit tests. If your code has dependencies on another class or interface, they can help you simulate those dependencies and verify the behavior of the called dependencies. For example, a piece of code has dependencies like this:
