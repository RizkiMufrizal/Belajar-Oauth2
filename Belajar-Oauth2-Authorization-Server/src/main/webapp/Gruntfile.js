'use strict';

module.exports = function(grunt) {

  grunt.initConfig({
    wiredep: {
      task: {
        src: [
          'pages/*.html'
        ]
      }
    }
  });

  grunt.loadNpmTasks('grunt-wiredep');
};
