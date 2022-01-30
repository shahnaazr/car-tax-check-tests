# Test Repo
This is  test repo to test

Write a test automation suite which does following.
1. Reads given input file: car_input.txt
2. Extracts vehicle registration numbers based on pattern(s).
3. Each number extracted from input file is fed to https://cartaxcheck.co.uk/
   (Peform Free Car Check)
4. Compare the output returned by https://cartaxcheck.co.uk/ with given
   car_output.txt
5. Highlight/fail the test for any mismatches.

## Technology used
This uses maven as a build tool.
Java as a programming language.
Selenium WebDriver to interact with the browser.
Junit 5 as a unit test library.

