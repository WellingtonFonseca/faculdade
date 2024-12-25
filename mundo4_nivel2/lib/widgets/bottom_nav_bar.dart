import 'package:flutter/material.dart';

class BottomNavBar extends StatelessWidget {
  const BottomNavBar({super.key});

  @override
  Widget build(BuildContext context) {
    return BottomNavigationBar(
      items: const [
        BottomNavigationBarItem(icon: Icon(Icons.home), label: 'Início'),
        BottomNavigationBarItem(icon: Icon(Icons.flight), label: 'Destinos'),
        BottomNavigationBarItem(
            icon: Icon(Icons.contact_page), label: 'Contato'),
      ],
    );
  }
}
