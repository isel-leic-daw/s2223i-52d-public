const path = require('path')

module.exports = {
    mode: 'development',
    entry : './src/index.ts',
    output :  {
        filename : "main.js",
        path: path.resolve(__dirname, 'dist')
    },
    devServer: {
        static: path.resolve(__dirname, 'dist'),
        historyApiFallback: true,
        compress: false,
        proxy: {
            '/api': 'http://localhost:9000 '
         }   
    },

    resolve: {
        extensions: ['.tsx', '.ts', '.js'],
      },
    module: {
        rules: [
            {
                test: /\.tsx?$/,
                use: 'ts-loader',
                exclude: /node_modules/,
            },
        ],
    }, 
};