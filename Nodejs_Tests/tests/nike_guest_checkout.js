var helper=require('../lib/helper.js')
module.exports = {
  'Guest Checkout FUnctionality' : function (browser) {
    browser
    .url('http://store.nike.com');
    helper.wait_click(browser,'#footer > div.non-employee-user > div > section > div > div > div > div > div.nike-cq-footer-three > div > div > div.nike-cq-list > ul > li > a')
    .wait_click(browser,'body > div.tunnel-content.nsg-font-family--platform > div.region-tunnel-content > div.languages > div.regions.Americas > div > ul > ul > li.size-medium.US > a')
    .wait_click(browser,'#main-content > div > div > div > div > section.nike-cq-page-module.nike-cq-page-menu.nike-cq-mod-pos-2 > div > div > div > div > div > div > div > ul > li.nike-cq-page-menu-item.nike-cq-page-menu-item1.nike-cq-page-menu-item-level1.hide > a')
    .wait_click(browser,'#main-content > div > div > div > div > section.nike-cq-page-module.nike-cq-page-menu.nike-cq-mod-pos-2 > div > div > div > div > div > div > div > ul > li.nike-cq-page-menu-item.nike-cq-page-menu-item1.nike-cq-page-menu-item-level1 > div > ul > li.nike-cq-page-menu-item.nike-cq-page-menu-item2.nike-cq-page-menu-item-level2.hide > a')
    .wait_click(browser,'#main-content > div > div > div > div > section.nike-cq-page-module.nike-cq-page-menu.nike-cq-mod-pos-2 > div > div > div > div > div > div > div > ul > li.nike-cq-page-menu-item.nike-cq-page-menu-item1.nike-cq-page-menu-item-level1 > div > ul > li.nike-cq-page-menu-item.nike-cq-page-menu-item2.nike-cq-page-menu-item-level2 > div > ul > li.nike-cq-page-menu-item.nike-cq-page-menu-item2.nike-cq-page-menu-item-level3.nike-cq-page-menu-item-link-only > a')
    .wait_click(browser,'#exp-gridwall-wrapper > div.exp-gridwall > div > div > div.exp-product-wall > div:nth-child(2) > div > div > div.grid-item-image > div > a > img')
    .executeAsync(browser,'window.scrollBy(0,350)')
    .wait_click(browser,'#pdp-size-select')
    .executeAsync(browser,'document.getElementById("frm-size-select").selectedIndex=1')
    .wait_click(browser,'#add-to-cart-btn')
    
//    .setValue('input[type=text]', 'nightwatch')
//    .waitForElementVisible('button[name=btnG]', 1000)
//    .click('button[name=btnG]')
//    .pause(1000)
//    .assert.containsText('#main', 'Night Watch')
//    .end();
    }
};
