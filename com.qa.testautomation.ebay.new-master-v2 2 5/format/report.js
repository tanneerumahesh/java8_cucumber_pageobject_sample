$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/SearchResults.feature");
formatter.feature({
  "name": "Search Results. Where one can sort, filter and see details of resulting products.",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Search and verify results",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@001"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am a non-registered customer",
  "keyword": "Given "
});
formatter.match({
  "location": "NativeConstructorAccessorImpl.java:-2"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to \"http://www.ebay.co.uk\"",
  "keyword": "And "
});
formatter.match({
  "location": "NativeConstructorAccessorImpl.java:-2"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I search for an \"cycle\"",
  "keyword": "When "
});
formatter.match({
  "location": "NativeConstructorAccessorImpl.java:-2"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I get a list of matching results",
  "keyword": "Then "
});
formatter.match({
  "location": "NativeConstructorAccessorImpl.java:-2"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the resulting items cards show: postage price, No of bids, price or show BuyItNow tag",
  "keyword": "And "
});
formatter.match({
  "location": "NativeConstructorAccessorImpl.java:-2"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I can sort the results by Lowest Price",
  "keyword": "Then "
});
formatter.match({
  "location": "NativeConstructorAccessorImpl.java:-2"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the results are listed in the page in the correct order",
  "keyword": "And "
});
formatter.match({
  "location": "NativeConstructorAccessorImpl.java:-2"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I can sort the results by Highest Price",
  "keyword": "Then "
});
formatter.match({
  "location": "NativeConstructorAccessorImpl.java:-2"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I can filter the results by \u0027Buy it now\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "NativeConstructorAccessorImpl.java:-2"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "all the results shown in the page have the \u0027Buy it now\u0027 tag",
  "keyword": "And "
});
formatter.match({
  "location": "NativeConstructorAccessorImpl.java:-2"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});