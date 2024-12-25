import 'package:flutter/material.dart';

void main() {
  runApp(
    MaterialApp(
      home: StatelessWidgetExemplo("Olá Flutter - MaterialApp"),
    ),
  );
}

class StatelessWidgetExemplo extends StatelessWidget {
  final String _appBarTitle;

  // Construtor que recebe o título como argumento
  StatelessWidgetExemplo(this._appBarTitle) : super();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(_appBarTitle),
      ),
      body: Center(
        child: Text(
          'Macoratti .net',
          style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
        ),
      ),
    );
  }
}
