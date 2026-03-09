package io.github.grexjr.asciidungeon.controller;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.NonBlockingReader;

import java.io.IOException;

public class InputHandler implements AutoCloseable {

    private final Terminal terminal;
    private final NonBlockingReader reader;

    public InputHandler() throws IOException {
        // Initialize terminal and do its setup
        this.terminal = TerminalBuilder.builder().system(true).build();
        this.terminal.enterRawMode();
        this.terminal.echo(false);

        this.reader = this.terminal.reader();
    }

    public int getRawKeyPress() throws IOException{
        return reader.read();
    }

    @Override
    public void close() throws IOException {
        terminal.close();
    }





}
