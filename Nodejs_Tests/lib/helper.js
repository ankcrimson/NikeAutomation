module.exports = {
	  wait_click: function (browser,tag) {
      // whatever
      browser.waitForElementVisible(tag, 10000)
      .click(tag)
      return this;
   },

   executeAsync: function(browser,str){
   	browser.executeAsync(str)
   	.pause(3000)
   	return this
   }
    };
