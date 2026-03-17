var exec = require('cordova/exec');

exports.show = function(success, error) {
    exec(success, error, "CustomSplash", "showSplash", []);
};

exports.hide = function(success, error) {
    exec(success, error, "CustomSplash", "hideSplash", []);
};
