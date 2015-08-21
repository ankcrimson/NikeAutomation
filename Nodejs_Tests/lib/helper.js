module.exports = {
	  wait_click: function (browser,tag) {
      // whatever
      try{
      browser.waitForElementVisible(tag, 20000)
<<<<<<< HEAD
      .waitForElementNotVisible('div.loading-overlay',10000,false)
=======
      .waitForElementNotVisible('div.loading-overlay',10000)
>>>>>>> ca74a8d68861f93a670ef28da3fa80dbc3dc5747
      .click(tag)
      }catch (err) {
      console.error('catastrophe', err);
      }
      return this;
   },

   executeAsync: function(browser,str){
   	try{
      browser.executeAsync(str)
<<<<<<< HEAD
   	//.pause(3000)
=======
   	.pause(3000)
>>>>>>> ca74a8d68861f93a670ef28da3fa80dbc3dc5747
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
