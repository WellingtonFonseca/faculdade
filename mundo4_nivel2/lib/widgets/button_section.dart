import 'package:flutter/material.dart';

// Seção de Botões
class ButtonSection extends StatelessWidget {
  const ButtonSection({super.key});

  // Método auxiliar para criar as colunas de botões
  Column _buildButtonColumn(Color color, IconData icon, String label) {
    return Column(
      mainAxisSize: MainAxisSize.min,
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Icon(icon, color: color),
        Container(
          margin: const EdgeInsets.only(top: 8),
          child: Text(
            label,
            style: TextStyle(
              fontSize: 12,
              fontWeight: FontWeight.w400,
              color: color,
            ),
          ),
        ),
      ],
    );
  }

  @override
  Widget build(BuildContext context) {
    // Cor padrão
    Color color = Theme.of(context).primaryColor;

    // Criação da linha de botões
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceEvenly,
      children: [
        _buildButtonColumn(color, Icons.call, 'LIGAR'),
        _buildButtonColumn(color, Icons.near_me, 'ROTA'),
        _buildButtonColumn(color, Icons.share, 'COMPARTILHAR'),
      ],
    );
  }
}
