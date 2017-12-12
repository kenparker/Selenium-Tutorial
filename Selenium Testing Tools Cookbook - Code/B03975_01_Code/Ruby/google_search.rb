require "selenium-webdriver"
gem "test-unit"
require "test/unit"

class GoogleSearch < Test::Unit::TestCase
  def setup
    @driver = Selenium::WebDriver.for :firefox
    @base_url = "https://www.google.com/"
    @driver.manage.timeouts.implicit_wait = 30
  end
    
  def test_google_search
    @driver.get(@base_url)
    
    element = @driver.find_element(:id, "q")
    element.clear
    element.send_keys "Selenium testing tools cookbook"
    element.submit()
    
    wait = Selenium::WebDriver::Wait.new(:timeout => 10)
    wait.until { @driver.title.include? "Selenium testing tools cookbook" }
    assert_equal "Selenium testing tools cookbook - Google Search", @driver.title
  end

  def teardown
    @driver.quit
  end
end
