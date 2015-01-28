(function (GLOBAL) {
    "use strict";

    GLOBAL.MyApp = {
        create: function (data) {
            return React.createClass({
                render: function () {
                    return React.DOM.div(
                        null,
                        React.DOM.h1(null, "Hello, " + this.props.name));
                }
            })(data);
        }
    };

}(this));
