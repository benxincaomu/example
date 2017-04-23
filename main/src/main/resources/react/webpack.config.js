const HtmlWebpackPlugin = require('html-webpack-plugin');

const HTMLWebpackPluginConfig = new HtmlWebpackPlugin({
    template: './src/index.html',
    filename: 'index.html',
    inject: 'body'
});

module.exports = {
    entry: [
        './src/index.js'
    ],
    output: {
        path: '../static/',
        filename: 'index_bundle.js'
    },
    module: {
        loaders: [
            {
                test: 'jquery',
                loader: 'expose?jQuery!expose?$'
            },
            {
                test: /\.js$/,
                exclude: /node_modules/,
                loader: 'babel-loader',
                query: {
                    presets: ['es2015', 'react'],
                    plugins: [
                        ['import', [{ libraryName: "antd", style: 'css' }]]
                    ]
                }
            },
            { test: /\.css$/, loader: 'style!css' }
        ]
    },
    devServer: {
        inline: true,
        port: 8000,
        host: '0.0.0.0',
        proxy: {
            '/login/**': {
                target: 'http://127.0.0.1:9000',
                secure: false
            },
            '/web/**': {
                target: 'http://127.0.0.1:9000',
                secure: false
            }

        }
    },
    plugins: [HTMLWebpackPluginConfig]
};