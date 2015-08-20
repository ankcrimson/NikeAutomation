module.exports = {
	  wait_click: function (browser,tag) {
      // whatever
      browser.waitForElementVisible(tag, 20000)
      .click(tag)
      return this;
   },

   executeAsync: function(browser,str){
   	browser.executeAsync(str)
   	.pause(3000)
   	return this
   },

   wait_setValue: function(browser,tag,str)
   {
   	browser.waitForElementVisible(tag, 10000)
   	.setValue(tag,str)
   	 return this
   },

   pause: function(browser,timee)
   {
   	browser.pause(browser,timee)
   	 console.log("pausing for "+timee);
       return this
   }
    };
