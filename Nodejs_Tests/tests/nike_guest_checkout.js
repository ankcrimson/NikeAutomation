var helper=require('../lib/helper.js')
module.exports = {
  'Guest Checkout FUnctionality' : function (browser) {
    browser
  //  .url('http://store.nike.com');
    .url('http://www.nike.com/language_tunnel');   
    helper
 //   .wait_click(browser,'#footer > div.non-employee-user > div > section > div > div > div > div > div.nike-cq-footer-three > div > div > div.nike-cq-list > ul > li > a')
    .wait_click(browser,'body > div.tunnel-content.nsg-font-family--platform > div.region-tunnel-content > div.languages > div.regions.Americas > div > ul > ul > li.size-medium.US > a')
    .wait_click(browser,'#main-content > div > div > div > div > section.nike-cq-page-module.nike-cq-page-menu.nike-cq-mod-pos-2 > div > div > div > div > div > div > div > ul > li.nike-cq-page-menu-item.nike-cq-page-menu-item1.nike-cq-page-menu-item-level1.hide > a')
    .wait_click(browser,'#main-content > div > div > div > div > section.nike-cq-page-module.nike-cq-page-menu.nike-cq-mod-pos-2 > div > div > div > div > div > div > div > ul > li.nike-cq-page-menu-item.nike-cq-page-menu-item1.nike-cq-page-menu-item-level1 > div > ul > li.nike-cq-page-menu-item.nike-cq-page-menu-item2.nike-cq-page-menu-item-level2.hide > a')
    .wait_click(browser,'#main-content > div > div > div > div > section.nike-cq-page-module.nike-cq-page-menu.nike-cq-mod-pos-2 > div > div > div > div > div > div > div > ul > li.nike-cq-page-menu-item.nike-cq-page-menu-item1.nike-cq-page-menu-item-level1 > div > ul > li.nike-cq-page-menu-item.nike-cq-page-menu-item2.nike-cq-page-menu-item-level2 > div > ul > li.nike-cq-page-menu-item.nike-cq-page-menu-item2.nike-cq-page-menu-item-level3.nike-cq-page-menu-item-link-only > a')
    .wait_click(browser,'#exp-gridwall-wrapper > div.exp-gridwall > div > div > div.exp-product-wall > div:nth-child(2) > div > div > div.grid-item-image > div > a > img')
    .executeAsync(browser,'javascript:window.scrollBy(0,350)')
//    .wait_click(browser,'#pdp-size-select')
    .wait_click(browser,'#frm-size-select option:nth-child(2)')
    .executeAsync(browser,'javascript:document.getElementById("frm-size-select").selectedIndex=2')
    .wait_click(browser,'#add-to-cart-btn')
   // .pause_1(browser,15000)
//    .wait_click(browser,'#header > div.tier0 > a.cart')
    .wait_click(browser,'a.cart')
  //  .pause_1(browser,6000)
    //.wait_click(browser,'div.js-guestCheckout.ch4_btn.ch4_btnOrange.cartButton')
    .wait_click(browser,'div.cartButton')
    .executeAsync(browser,'javascript:window.scrollBy(0,800)')
    .wait_setValue(browser,'#fname','Capt Jack')
    .wait_setValue(browser,'#lname','Sparrow')
    .wait_setValue(browser,'#address1Field','Black Perl')
    .wait_setValue(browser,'#address2Field','Caribbean Sea')
    .wait_setValue(browser,'#cityField','Beaverton')
    .wait_setValue(browser,'#postalCodeField','97005')
    .wait_setValue(browser,'#shippingEmailField','captian@blackperl.org')

//    .setValue('input[type=text]', 'nightwatch')
//    .waitForElementVisible('button[name=btnG]', 1000)
//    .click('button[name=btnG]')
//    .pause(1000)
//    .assert.containsText('#main', 'Night Watch')
//    .end();
    }
};
