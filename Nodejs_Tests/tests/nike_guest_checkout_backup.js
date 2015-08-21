var helper=require('../lib/helper.js')
module.exports = {
  'Guest Checkout FUnctionality' : function (browser) {
    browser
  //  .url('http://store.nike.com');
    .url('http://www.nike.com/language_tunnel');   
    
 //   .click('#footer > div.non-employee-user > div > section > div > div > div > div > div.nike-cq-footer-three > div > div > div.nike-cq-list > ul > li > a')
    .executeAsync('alert()')
    .click('body > div.tunnel-content.nsg-font-family--platform > div.region-tunnel-content > div.languages > div.regions.Americas > div > ul > ul > li.size-medium.US > a')
    .click('#main-content > div > div > div > div > section.nike-cq-page-module.nike-cq-page-menu.nike-cq-mod-pos-2 > div > div > div > div > div > div > div > ul > li.nike-cq-page-menu-item.nike-cq-page-menu-item1.nike-cq-page-menu-item-level1.hide > a')
    .click('#main-content > div > div > div > div > section.nike-cq-page-module.nike-cq-page-menu.nike-cq-mod-pos-2 > div > div > div > div > div > div > div > ul > li.nike-cq-page-menu-item.nike-cq-page-menu-item1.nike-cq-page-menu-item-level1 > div > ul > li.nike-cq-page-menu-item.nike-cq-page-menu-item2.nike-cq-page-menu-item-level2.hide > a')
    .click('#main-content > div > div > div > div > section.nike-cq-page-module.nike-cq-page-menu.nike-cq-mod-pos-2 > div > div > div > div > div > div > div > ul > li.nike-cq-page-menu-item.nike-cq-page-menu-item1.nike-cq-page-menu-item-level1 > div > ul > li.nike-cq-page-menu-item.nike-cq-page-menu-item2.nike-cq-page-menu-item-level2 > div > ul > li.nike-cq-page-menu-item.nike-cq-page-menu-item2.nike-cq-page-menu-item-level3.nike-cq-page-menu-item-link-only > a')
    .click('#exp-gridwall-wrapper > div.exp-gridwall > div > div > div.exp-product-wall > div:nth-child(2) > div > div > div.grid-item-image > div > a > img')
    .executeAsync('window.scrollBy(0,350)')
    .pause(2000)
//    .click('#pdp-size-select')
    .click('#frm-size-select option:nth-child(2n)')
    .click('#add-to-cart-btn')
   // .pause_1(15000)
//    .click('#header > div.tier0 > a.cart')
    .click('a.cart')
    .executeAsync('window.scrollBy(0,450)')
    .pause(2000)
    .setValue('#fname','Capt Jack')
    .setValue('#lname','Sparrow')
    .setValue('#address1Field','Black Perl')
    .setValue('#address2Field','Caribbean Sea')
    .setValue('#cityField','Beaverton')
    .setValue('#postalCodeField','97005')
    .setValue('#shippingEmailField','captian@blackperl.org')

//    .setValue('input[type=text]', 'nightwatch')
//    .waitForElementVisible('button[name=btnG]', 1000)
//    .click('button[name=btnG]')
//    .pause(1000)
//    .assert.containsText('#main', 'Night Watch')
//    .end();
    }
};
