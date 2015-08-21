module.exports = {
	  wait_click: function (browser,tag) {
      // whatever
      try{
      browser.waitForElementVisible(tag, 20000)
      .waitForElementNotVisible('div.loading-overlay',10000,false)
      .click(tag)
      }catch (err) {
      console.error('catastrophe', err);
      }
      return this;
   },

   executeAsync: function(browser,str){
   	try{
      browser.executeAsync(str)
   	//.pause(3000)
   	}catch (err) {
      console.error('catastrophe', err);
      }
      
      return this
   },

   wait_setValue: function(browser,tag,str)
   {
   	try{
      browser.waitForElementVisible(tag, 10000)
   	.setValue(tag,str)
   	}catch (err) {
      console.error('catastrophe', err);
      }
      
       return this
   },

   pause_1: function(browser,timee)
   {
   	try{
      browser.pause(browser,timee)
   	}catch (err) {
      console.error('catastrophe', err);
      }
      return this
   }
    };
